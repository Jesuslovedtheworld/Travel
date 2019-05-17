# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Gson
-keep class com.google.gson.stream.** { *; }
-keepattributes EnclosingMethod


##---------------Begin: proguard configuration for Gson ----------
 -keep public class com.google.gson.**
 -keep public class com.google.gson.** {public private protected *;}

 -keep public class com.project.mocha_patient.login.SignResponseData { private *; }

 ##---------------End: proguard configuration for Gson ----------

  #保护注解
-keepattributes *Annotation*
# 保持哪些类不被混淆
  -keep public class * extends android.app.Fragment
  -keep public class * extends android.app.Activity
  -keep public class * extends android.support.v7.app.AppCompatActivity
  -keep public class * extends android.app.Application
  -keep public class * extends android.app.Service
  -keep public class * extends android.content.BroadcastReceiver
  -keep public class * extends android.content.ContentProvider
  -keep public class * extends android.app.backup.BackupAgentHelper
  -keep public class * extends android.preference.Preference
  -keep public class com.android.vending.licensing.ILicensingService
  #如果有引用v4包可以添加下面这行
  -keep public class * extends android.support.v4.app.Fragment

  ## 自定义控件
  -keep class com.everywhere.trip.widget.**{*;}


  #忽略警告
  -ignorewarning
  #agentweb
  -keep class com.just.agentweb.** {
      *;
  }
  -dontwarn com.just.agentweb.**
  -keepclassmembers class com.just.agentweb.sample.common.AndroidInterface{ *; }

  #StatusBarUtil
  -keep class com.jaeger.library.**{}

  #友盟配置  start
  -dontshrink
  -dontoptimize
  -dontwarn com.google.android.maps.**
  -dontwarn android.webkit.WebView
  -dontwarn com.umeng.**
  -dontwarn com.tencent.weibo.sdk.**
  -dontwarn com.facebook.**
  -keep public class javax.**
  -keep public class android.webkit.**
  -dontwarn android.support.v4.**
  -keep enum com.facebook.**
  -keepattributes Exceptions,InnerClasses,Signature
  -keepattributes *Annotation*
  -keepattributes SourceFile,LineNumberTable

  -keep public interface com.facebook.**
  -keep public interface com.tencent.**
  -keep public interface com.umeng.socialize.**
  -keep public interface com.umeng.socialize.sensor.**
  -keep public interface com.umeng.scrshot.**

  -keep public class com.umeng.socialize.* {*;}


  -keep class com.facebook.**
  -keep class com.facebook.** { *; }
  -keep class com.umeng.scrshot.**
  -keep public class com.tencent.** {*;}
  -keep class com.umeng.socialize.sensor.**
  -keep class com.umeng.socialize.handler.**
  -keep class com.umeng.socialize.handler.*
  -keep class com.umeng.weixin.handler.**
  -keep class com.umeng.weixin.handler.*
  -keep class com.umeng.qq.handler.**
  -keep class com.umeng.qq.handler.*
  -keep class UMMoreHandler{*;}
  -keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
  -keep class com.tencent.mm.sdk.modelmsg.** implements com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
  -keep class im.yixin.sdk.api.YXMessage {*;}
  -keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
  -keep class com.tencent.mm.sdk.** {
     *;
  }
  -keep class com.tencent.mm.opensdk.** {
     *;
  }
  -keep class com.tencent.wxop.** {
     *;
  }
  -keep class com.tencent.mm.sdk.** {
     *;
  }
  -dontwarn twitter4j.**
  -keep class twitter4j.** { *; }

  -keep class com.tencent.** {*;}
  -dontwarn com.tencent.**
  -keep class com.kakao.** {*;}
  -dontwarn com.kakao.**
  -keep public class com.umeng.com.umeng.soexample.R$*{
      public static final int *;
  }
  -keep public class com.linkedin.android.mobilesdk.R$*{
      public static final int *;
  }
  -keepclassmembers enum * {
      public static **[] values();
      public static ** valueOf(java.lang.String);
  }

  -keep class com.tencent.open.TDialog$*
  -keep class com.tencent.open.TDialog$* {*;}
  -keep class com.tencent.open.PKDialog
  -keep class com.tencent.open.PKDialog {*;}
  -keep class com.tencent.open.PKDialog$*
  -keep class com.tencent.open.PKDialog$* {*;}
  -keep class com.umeng.socialize.impl.ImageImpl {*;}
  -keep class com.sina.** {*;}
  -dontwarn com.sina.**
  -keep class  com.alipay.share.sdk.** {
     *;
  }

  -keepnames class * implements android.os.Parcelable {
      public static final ** CREATOR;
  }

  -keep class com.linkedin.** { *; }
  -keep class com.android.dingtalk.share.ddsharemodule.** { *; }
  -keepattributes Signature
      #友盟配置  end


#百度代码混淆
-keep class com.baidu.** {*;}
-keep class mapsdkvi.com.** {*;}
-dontwarn com.baidu.**







