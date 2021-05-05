package jp.empressia.message.generated;

import java.util.Locale;
import jakarta.annotation.Generated;

import jp.empressia.message.MessageTemplate;
import jp.empressia.message.generated.ValidationMessage.MessageTemplateFor0Args;

/**
 * アプリケーションドメインにおける例外を表現します。
 * @author すふぃあ}
 */
@Generated("jp.empressia.message.generator.MessageGenerator")
public class ValidationMessageException extends RuntimeException {

	/** メッセージ、および、メッセージのテンプレートです。 */
	private MessageTemplate Message;
	/** メッセージ引数です。 */
	private Object[] MessageArgs;
	
	/** メッセージIDを取得します。 */
	public String getMessageID() { return this.Message.getID(); }
	/** メッセージ引数を取得します。 */
	public Object[] getMessageArgs() { return this.MessageArgs; }
	
	private Formatter Formatter;
	
	/** メッセージを取得します。 */
	public String getMessage() {
		String message = this.Formatter.format(null);
		return message;
	}
	
	/** メッセージを取得します。 */
	public String getMessage(Locale locale) {
		String message = this.Formatter.format(locale);
		return message;
	}
	
	/**
	 * コンストラクタです。
	 * @param Message messages.propertiesにあるメッセージIDに対応するMessage定数
	 * @param MessageArgs メッセージに埋め込む引数
	 * @param Formatter メッセージをフォーマットする関数
	 */
	private ValidationMessageException(MessageTemplate Message, Object[] MessageArgs, Formatter Formatter) {
		super(Message.getID());
		this.Message = Message;
		this.MessageArgs = MessageArgs;
		this.Formatter = Formatter;
	}

	/**
	 * コンストラクタです。
	 * @param message messages.propertiesにあるメッセージIDに対応するMessage定数
	 */
	public ValidationMessageException(MessageTemplateFor0Args message) {
		this(message, new Object[] {}, (l) -> message.format(l));
	}

	/**
	 * メッセージをフォーマットするためのインターフェースです。
	 * @author すふぃあ
	 */
	@FunctionalInterface
	public interface Formatter {
		/**
		 * メッセージをフォーマットします。
		 * @param locale 指定がない場合はnullです。
		 */
		public String format(Locale locale);
	}

}
