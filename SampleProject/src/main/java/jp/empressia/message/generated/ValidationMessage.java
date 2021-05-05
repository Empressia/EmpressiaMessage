package jp.empressia.message.generated;

import java.util.Locale;
import jakarta.annotation.Generated;

import jp.empressia.message.MessageTemplate;

/**
 * メッセージを表現します。
 * @author すふぃあ
 */
@Generated("jp.empressia.message.generator.MessageGenerator")
public class ValidationMessage {

	/**
	 * メッセージのIDを表現します。
	 * @author すふぃあ
	 */
	@Generated("jp.empressia.message.generator.MessageGenerator")
	public static enum ID {
		/** 『ぬるはダメです。』*/
		NOT_NULL("NOT_NULL"),
		;
		/** IDの文字列表現です。 */
		private String IDString;
		/** コンストラクタ。 */
		private ID(String IDString) {
			this.IDString = IDString;
		}
		/** IDの文字列表現を提供します。 */
		public String getAsString() {
			return this.IDString;
		}
		/**
		 * メッセージのIDの文字列表現を定数で表現します。
		 * @author すふぃあ
		 */
		@Generated("jp.empressia.message.generator.MessageGenerator")
		public static class Constants {
			/** 『ぬるはダメです。』*/
			public static final String NOT_NULL = "NOT_NULL";
		}
	}

	/** 『ぬるはダメです。』 */
	public static final MessageTemplateFor0Args NOT_NULL = new MessageTemplateFor0Args(ID.NOT_NULL);

	/** このクラスに対応するメッセージの場所です。 */
	private static final String Location = "ValidationMessages";

	/**
	 * 埋め込みを0個持つメッセージです。
	 * @author すふぃあ
	 */
	@Generated("jp.empressia.message.generator.MessageGenerator")
	public static class MessageTemplateFor0Args extends MessageTemplate {
		/** コンストラクタ。 */
		private MessageTemplateFor0Args(ID ID) { super(ID.getAsString()); }
		/** メッセージを構築して提供します。 */
		public String format() {
			return this.format(ValidationMessage.Location, new Object[] {});
		}
		/** メッセージを構築して提供します。 */
		public String format(Locale locale) {
			return this.format(ValidationMessage.Location, new Object[] {}, locale);
		}
	}

}
