import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:get/get.dart';
import 'common/index.dart';
import 'global.dart';

Future<void> main() async {
  await Global.init();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ScreenUtilInit(
        designSize: const Size(414, 896), // 设计稿中设备的尺寸(单位随意,建议dp,但在使用过程中必须保持一致)
        splitScreenMode: false, // 支持分屏尺寸
        builder: (context, child) {

      return GetMaterialApp(
        debugShowCheckedModeBanner: false,
        initialRoute: RouteNames.splash,
        //theme: appThemeData,
        //defaultTransition: Transition.fade,
        getPages: RoutePages.routes,
        translations: Translation(),
        // 主题
        theme: AppTheme.light,
        darkTheme: AppTheme.dark,
        themeMode:
        ConfigService.inject.isDarkModel ? ThemeMode.dark : ThemeMode.light,

        // 词典
        localizationsDelegates: Translation.localizationsDelegates,
        // 代理
        supportedLocales: Translation.supportedLocales,
        // 支持的语言种类
        locale: ConfigService.inject.locale,
        // 当前语言种类
        fallbackLocale: Translation.fallbackLocale, // 默认语言种类

        // builder
        builder: (context, widget) {
          // 不随系统字体缩放比例
          return MediaQuery(
            data: MediaQuery.of(context).copyWith(textScaleFactor: 1.0),
            child: widget!,
          );
        },
      );
    });
  }
}
