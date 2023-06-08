import 'package:blog/common/index.dart';
import 'package:flutter_native_splash/flutter_native_splash.dart';
import 'package:get/get.dart';

class StylesController extends GetxController {
  StylesController();

  _initData() {
    update(["styles"]);
  }

  // 主题
  onThemeSelected() async {
    await ConfigService.inject.switchThemeModel();
    update(["styles_index"]);
  }

  void onTap() {}

  // @override
  // void onInit() {
  //   super.onInit();
  // }

  @override
  void onReady() {
    super.onReady();
    FlutterNativeSplash.remove();
    _initData();
  }

  // @override
  // void onClose() {
  //   super.onClose();
  // }
}
