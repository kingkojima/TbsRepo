package jp.ne.tbs.frame.AA00;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.font.TextHitInfo;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;

/**
 * 一般文字入力フィールドクラスです。
 * <p>
 */
public class JTextFieldEx extends JTextField {

    /** 変換モード指定定数：指定なし */
    public static final int IM_NONE        = 0;
    /** 変換モード指定定数：ひらがな */
    public static final int IM_HIRAGANA    = 1;
    /** 変換モード指定定数：半角カナ */
    public static final int IM_HALFKANA    = 2;
    /** 変換モード指定定数：全角英数 */
    public static final int IM_FULLASCII   = 3;
    /** 変換モード指定定数：直接入力 */
    public static final int IM_OFF         = 4;

    private int maxLength = 0;
    private int imType    = IM_NONE;

    /**
     * 列数、文字列長、変換モードを指定してフィールドを作成します。
     * <p>
     *
     * @param columns 列数
     * @param maxLength 文字列長
     * @param imType 変換モード
     */
    public JTextFieldEx(int columns, int type, int maxLength, int imType){
        super(columns);
        setMaxLength(maxLength);
        setIMType(imType);
        addFocusListener(new HogeFieldListener());
    }

    /**
     * フィールドに文字列を設定します。
     * <p>
     * ドキュメントクラスのinsertStringメソッドをカスタマイズしているため、
     * オーバーライドして指定した文字列が挿入できるようにします。
     * <br>
     * オーバーライドされたこのメソッドを使用した場合には入力制限に関係なく
     * 文字列を設定することができます。
     * <p>
     *
     * @param str フィールドに設定する文字列
     */
    public void setText(String str) {
        Document doc = getDocument();
        HogeDocument hogeDoc = null;
        if(doc instanceof HogeDocument) {
            hogeDoc = (HogeDocument)doc;
        }
        if (hogeDoc != null) {
            //ドキュメントクラスのsetText()で文字列を挿入
            hogeDoc.setText(str);
            moveCaretPosition(0);
        }
    }

    /**
     * 入力制限文字列長を設定します。
     * <p>
     *
     * @param maxLength 入力制限文字列長
     */
    public void setMaxLength(int maxLength) {
        if (maxLength < 0) {
            this.maxLength = 0;
            return;
        }
        this.maxLength = maxLength;
    }

    /**
     * 入力制限文字列長を取得します。
     * <p>
     *
     * @return 入力制限文字列長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 変換モードを設定します。
     * <p>
     *
     * @param imType 変換モード
     */
    public void setIMType(int imType) {
        this.imType = imType;
    }

    /**
     * 変換モードを取得します。
     * <p>
     *
     * @return 変換モード
     */
    public int getIMType() {
        return imType;
    }

    /**
     * ドキュメントクラスを作成して取得します。
     * <p>
     *
     * @return このクラスのドキュメントクラス
     */
    protected Document createDefaultModel() {
        return new HogeDocument(this);
    }

    /**
     * HogeFieldドキュメントクラスです。
     * <p>
     * 入力文字列の属性を保存しておく必要があるため、
     * PlainDocumentではなく、DefaultStyledDocumentを拡張しています。
     */
    class HogeDocument extends DefaultStyledDocument {

    	JTextFieldEx parent = null;

        /**
         * このドキュメントクラスを使用するフィールドの参照を設定して
         * オブジェクトを作成します。
         * <p>
         *
         * @param parent
         */
        public HogeDocument(JTextFieldEx initParent){
            super();
            parent = initParent;
        }

        /**
         * ドキュメントの文字列を設定します。<br>
         * 親クラスのremove()、insertString()を呼び出して
         * 入力制限やフォーカス制限を無視した文字列の挿入を実現しています。
         * <p>
         *
         * @param str 設定する文字列
         */
        protected void setText(String str) {
            try {
                super.remove(0, getLength());
                super.insertString(0, str, null);
            } catch (BadLocationException e) {
                //ignore
            }
        }

        /**
         * IME未確定文字列があった場合にIMEが
         * 未確定文字列を挿入してしまうのを防ぐために
         * フォーカスの無いときにはremoveさせないようにオーバーライドします。
         * <p>
         *
         * @param offs   オフセットの開始
         * @param length 削除対象の文字数
         */
        public void remove(int offs , int length)
            throws BadLocationException{
            if(!hasFocus()){
                return;
            }
            super.remove(offs, length);
        }

        /**
         * 親クラスのremove(int,int)をそのまま呼び出します。
         * <p>
         *
         * @param offs   オフセットの開始
         * @param length 削除対象の文字数
         */
        public void superRemove(int offs , int length)
            throws BadLocationException {
            super.remove(offs, length);
        }

        /**
         * フィールドに文字列が挿入される際に呼び出される挿入処理です。
         * <p>
         * 入力された文字列をフィールドに挿入する際にHogeFieldに
         * 設定されている入力制限文字数を超えたときには挿入処理を行いません。
         * <p>
         *
         * @param offs オフセット(挿入開始位置)
         * @param str  挿入文字列
         * @param a    AttributeSet（文字列の属性）
         * @exception  BadLocationException
         */
        public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {

            if(!hasFocus()){
                /*
                 * IME未確定文字列があった場合にIMEが
                 * 未確定文字列を挿入してしまうのを防ぐために
                 * フォーカスの無いときにはinsertStringを許しません。
                 */
                return;
            }

            // 文字列が入ってきていないのにメソッドが呼ばれた場合
            if (str == null) return;

            // IMEの変換中の文字列はそのままinsertする
            if ((a != null) &&
                (a.isDefined(StyleConstants.ComposedTextAttribute))) {
                super.insertString(offs, str, a);
                return;
            }

            // 入力文字列を一文字ずつ判定
            for (int i = 0; i < str.length(); i++){
                int  checkOffs = offs + i;
                char checkChar = str.charAt(i);

                /*
                 * MaxLength以上の文字切り捨て処理
                 */
                if (maxLength != 0){
                    try {
                        //現在入力されている文字列長を取得する。
                        int fieldLength =
                            parent.getText().getBytes().length;
                        //これから入力する文字の文字列長を取得する。
                        int insertStrLength =
                            String.valueOf(checkChar).getBytes().length;
                        if(fieldLength + insertStrLength > maxLength) {
                            //文字列長が制限を越えるのであれば挿入をしない。
                            return;
                        }
                    } catch(Exception e) {
                        return;
                    }
                }
                super.insertString(checkOffs, String.valueOf(checkChar), a);
            }
        }
    }

    /**
     * HogeFieldのフォーカスリスナクラスです。
     */
    class HogeFieldListener implements FocusListener{

        /**
         * フォーカス消失時にfocusLostHandler()を呼びます。
         * <p>
         *
         * @param event FocusEvent
         */
        public void focusLost(FocusEvent event){
            focusLostHandler();
        }

        /**
         * フォーカス取得時にfocusGainedHandler()を呼びます。
         * <p>
         *
         * @param event FocusEvent
         */
        public void focusGained(FocusEvent event){
            focusGainedHandler();
        }
    }

    /**
     * focusGained時の処理です。
     * <p>
     * ・文字列を全選択します。<br>
     * ・変換モードにIM_NONE以外を指定している場合、IMの制御を行います。
     */
    private void focusGainedHandler(){
        if (imType != IM_NONE) {
            Character.Subset[] subsets = null;
            switch (imType) {
                case IM_HIRAGANA :
                    subsets = new Character.Subset[] {java.awt.im.InputSubset.KANJI};
                    break;
                case IM_HALFKANA :
                    subsets = new Character.Subset[] {java.awt.im.InputSubset.HALFWIDTH_KATAKANA};
                    break;
                case IM_FULLASCII :
                    subsets = new Character.Subset[] {java.awt.im.InputSubset.FULLWIDTH_LATIN};
                    break;
                default :
                    subsets = null;
            }
            getInputContext().setCharacterSubsets(subsets);
        }
        //文字列を全選択状態にする。
        select(0, getText().length());
    }

    /**
     * focusLost時の処理です。
     * <p>
     * ・変換モードにIM_NONE以外を指定している場合、IMの制御を行います。
     */
    private void focusLostHandler() {
        if (imType != IM_NONE) {
            getInputContext().setCharacterSubsets(null);
        }
        //IME未確定文字列の削除
        removeUndecidedCharacters();
    }

    /**
     * IMEの未確定文字列を削除します。
     */
    public void removeUndecidedCharacters(){
        HogeDocument document = null;
        if(getDocument() instanceof HogeDocument){
            document = (HogeDocument)getDocument();
        }
        if(document == null){
            return;
        }
        int begin = 0;  //削除を始めるoffset
        int len   = 0;  //削除する文字数

        for(int i = 0; i < document.getLength(); i++){
            //文字列の属性を一文字ずつ調べる。
            Element e = document.getCharacterElement(i);
            if(e.getAttributes().isDefined(StyleConstants.ComposedTextAttribute)){
                //IMEの未確定文字列だった場合
                if(len == 0){
                    begin = i;
                }
                len++;
            }
        }
        if(len != 0){
            try {
                //IMEの未確定文字列を削除する。
                //この時にはフォーカスが無いのでremoveではなくsuperRemove()を呼び出す。
                document.superRemove(begin, len);

                if(imType == IM_NONE){
                    return;
                }
                /*
                 * IMEの操作をしている場合は
                 * キャレットをIME用ではないキャレットにするために
                 * 架空のInputEventを発生させます。
                 */
                //イベントの生成
                InputMethodEvent event =
                    new InputMethodEvent(this,
                                         InputMethodEvent.INPUT_METHOD_TEXT_CHANGED,
                                         null,
                                         0,
                                         TextHitInfo.beforeOffset(0),
                                         null);
                //イベントの実行
                processInputMethodEvent(event);
            }catch (BadLocationException ignore){
            }
        }
    }
}