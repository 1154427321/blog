import 'package:blog/common/index.dart';
import 'package:carousel_slider/carousel_controller.dart';
import 'package:get/get.dart';

class WelcomeController extends GetxController {
  WelcomeController();
  CarouselController carouselController = CarouselController(); // slider 控制器
  List<WelcomeModel>? items;

  // 去首页
  void onToMain() {
    Get.offAllNamed(RouteNames.main);
  }

  // 下一个
  void onNext() {
    carouselController.nextPage();
  }




  @override
  void onReady() {
    super.onReady();
    //设置已经打开
    ConfigService().setAlreadyOpen();
  }

  // @override
  // void onClose() {
  //   super.onClose();
  // }
}
