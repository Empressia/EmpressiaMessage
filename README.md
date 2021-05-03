# Empressia Message

## 目次

* [概要](#概要)
* [使い方](#使い方)
	* [クラスの基本的な生成方法](#クラスの基本的な生成方法)
	* [自動生成されたクラスの基本的な使い方](#自動生成されたクラスの基本的な使い方)
* [メッセージプロパティの配置場所](#メッセージプロパティの配置場所)
* [ライセンス](#ライセンス)

## 概要

Empressia製のメッセージ管理ライブラリ＆ツールです。  
できるだけタイプセーフに使えると良いなぁと思って作ってみています。  

なんか、ログライブラリはいっぱいあるのに、  
メッセージを管理するライブラリとかってあんまり見かけない気がするなぁと思って、作ってみました。  

Empressia Messageはいくつかのサブプロジェクト？から構成されています。  
* [ライブラリ（Empressia Message Library）](https://github.com/Empressia/EmpressiaMessageLibrary)
	* 基本的なメッセージ用のクラス群です。
* [Generator（Empressia Message Generator）](https://github.com/Empressia/EmpressiaMessageGenerator)
	* メッセージプロパティから、Empressia Message Libraryを使った専用のメッセージクラスを生成します。  
		Javaやコマンドラインから使用できます。
* [Gradle用プラグイン（Empressia Message Gradle Plugin）](https://github.com/Empressia/EmpressiaMessageGradlePlugin)
	* GeneratorをGradleから使いやすくするためのプラグインです。

## 使い方

Gralde用プラグインでメッセージ用のクラスを生成して、  
任意のJavaアプリケーション内で使用することを想定しています。  

クラスのGeneratorは、コマンドラインからも使えるので、Gralde以外でも使用できます。  

ここでは、Gradle用プラグインでクラスを生成する例と、  
ログ出力などのクラスの使用サンプルを示します。  

個々のライブラリやツールの詳細は、各サブプロジェクト？を参照してください。  
生成されたクラスの詳細については、生成されたクラスや、そのJavadocを参照してください。  

### クラスの基本的な生成方法

1. Gradleにライブラリの設定をします。

	`build.gradle`
	```groovy
	dependency {
		implementation(group:"jp.empressia", name="jp.empressia.gradle.plugin.message", version:"1.0.0");
	}
	```

	設定の詳細については、以下を参照してください。  
	* [Empressia Message Library#ライブラリの設定](https://github.com/Empressia/EmpressiaMessageLibrary#ライブラリの設定)

	※クラスの生成自体には必須ではありませんが、生成されたソースコードがコンパイルエラーにならないように設定します。  
	※最新のバージョンについては、Maven Centralなどで確認してください。

1. メッセージプロパティを用意します。

	例えば、以下のパスに配置します。   
	`/src/main/resources/message.properties`   

	```properties
	TEST0001=これは{0}です。
	```

	配置場所の詳細については、以下を参照してください。  
	* [Empressia Message Library#メッセージプロパティの配置場所](https://github.com/Empressia/EmpressiaMessageLibrary#メッセージプロパティの配置場所)

1. Gradleにプラグインを適用をします。

	`build.gradle`
	```groovy
	plugin {
		id "java";
		id "jp.empressia.gradle.plugin.message", version "1.0.0";
	}
	```

	設定の詳細については、以下を参照してください。  
	* [Empressia Message Gradle Plugin#使い方](https://github.com/Empressia/EmpressiaMessageGradlePlugin#使い方)

	※Javaプラグインの適用は必須ではありませんが、通常は設定することになると思います。  
	※最新のバージョンについては、Gralde Plugin Portalなどで確認してください。  

1. Gradleからタスクを実行します。

	Javaプラグインを適用していれば、以下のコマンドで実行できます。  
	`gradlew build`  
	他にも、  
	`gradlew compileJava`  
	などでも動作します。  

	単体で生成のタスクを実行する場合は、以下を実行します。  
	`gradlew generateEmpressiaMessage`  

	実行の詳細については、以下を参照してください。  
	* [Empressia Message Gradle Plugin#使い方](https://github.com/Empressia/EmpressiaMessageGradlePlugin#使い方)


### 自動生成されたクラスの基本的な使い方

基本的には、生成されたメッセージクラスの定数から、formatを呼び出して使います。
```java
	String message = Message.TEST0001.format("テスト");
```
アダプタークラスを用いると、もう少し短く以下のように書けます。
```java
	String message = Messages.TEST0001("テスト");
```

ログ出力に使う場合は、例えば、
```java
	logger(this).info(() -> Message.TEST0001.format("テスト"));
```
とか、
```java
	logger(this).info(() -> Messages.TEST0001("テスト"));
```
のようにします。

他に、例外の作成として、以下のように使います。
```java
	throw new MessageException(Message.TEST0001, "テスト");
```
実際には、継承したクラスを独自に用意する方が良いかもしれません。  

クラスの生成の時に、設定を変更することで、文字列表現としての定数を用意することもできます。  
アノテーションの引数などは、文字列定数でないと指定できないので、必要な場合は検討してみてください。  
```java
	@NotNull(message=Message.ID.Constants.TEST0000)
```

## ライセンス

各サブプロジェクト？のライセンスを確認してください。  
特に、記載がない場合は、以下の通りです。  

いつも通りのライセンスです。  
zlibライセンス、MITライセンスでも利用できます。  

ただし、チーム（複数人）で使用する場合は、MITライセンスとしてください。  
