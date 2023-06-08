
import 'package:blog/pages/index.dart';
import 'package:get/get.dart';

import 'index.dart';




class RoutePages {
  //列表
  static List<GetPage> routes = [
    GetPage(
        name: RouteNames.splash,
        page: () => SplashPage(),
      ),
    GetPage(
        name: RouteNames.systemWelcome,
        page: () => WelcomePage(),
      ),
    GetPage(
        name: RouteNames.main,
        page: () => MainPage(),
      ),
    GetPage(
        name: RouteNames.styles,
        page: () => StylesPage(),
      ),
    GetPage(
        name: RouteNames.mine,
        page: () => MinePage(),
      ),
    GetPage(
        name: RouteNames.login,
        page: () => LoginPage(),
      ),
  ];
}
