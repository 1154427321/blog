
import 'package:blog/common/index.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';


import 'index.dart';

class SplashPage extends GetView<SplashController> {
  const SplashPage({Key? key}) : super(key: key);

  // 主视图
  Widget _buildView() {
    return  Image.asset(AssetsImages.splashJpg,
      fit: BoxFit.fill,
    );
    // return Scaffold(
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<SplashController>(
      init: SplashController(),
      id: "splash",
      builder: (_) {
        return _buildView();
      },
    );
  }
}
