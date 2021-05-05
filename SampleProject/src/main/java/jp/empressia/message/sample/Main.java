package jp.empressia.message.sample;

import java.util.logging.Logger;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import jp.empressia.message.generated.Messages;
import jp.empressia.message.generated.ValidationMessage;

/**
 * Empressia Messageの出力サンプルです。
 * @author すふぃあ
 */
public class Main {

	/** entry pointです。 */
	public static void main(String[] args) {
		System.out.println(Messages.TEST000());
		System.out.println(Messages.TEST001("引数1"));
		System.out.println(Messages.TEST002("引数1", "引数2"));
		System.out.println(Messages.TEST003("引数1", "引数2", "引数3"));

		Logger.getLogger(Main.class.getName()).info(Messages.TEST000());
		Logger.getLogger(Main.class.getName()).info(() -> Messages.TEST001("引数1"));
		Logger.getLogger(Main.class.getName()).info(() -> Messages.TEST002("引数1", "引数2"));
		Logger.getLogger(Main.class.getName()).info(() -> Messages.TEST003("引数1", "引数2", "引数3"));

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		SomeObject someObject = new SomeObject();
		var results = validator.validate(someObject);
		for(var result : results) {
			System.out.println(result.getMessage());
		}
	}

	/**
	 * Jakarta Bean ValidationでのEmpressia Messageサンプルクラスです。
	 * @author すふぃあ
	 */
	public static class SomeObject {
		/** Nullは不許可なフィールドです。 */
		@NotNull(message="{" + ValidationMessage.ID.Constants.NOT_NULL + "}")
		public String ID;
	}

}
