import 'package:get/get.dart';
import 'package:blog/common/index.dart';

class MineController extends GetxController {
  MineController();

  _initData() {
    update(["mine"]);
  }

  void onTap() {}

  void toLogin(){
    Get.toNamed(RouteNames.login);
  }

  // @override
  // void onInit() {
  //   super.onInit();
  // }

  @override
  void onReady() {
    super.onReady();
    _initData();
  }

  // @override
  // void onClose() {
  //   super.onClose();
  // }
}
