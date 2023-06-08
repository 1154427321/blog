import 'package:blog/common/index.dart';
import 'package:dots_indicator/dots_indicator.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:introduction_screen/introduction_screen.dart';

import 'index.dart';

class WelcomePage extends GetView<WelcomeController> {
  const WelcomePage({Key? key}) : super(key: key);

  // 内容页
  Widget _buildView() {
    //单页样式
    var pd = new PageDecoration(
      bodyAlignment: Alignment.center,
      imageAlignment: Alignment.bottomCenter,
      imageFlex: 5,
      bodyFlex: 3,
    );
    return IntroductionScreen(
        //底部进度点
        dotsDecorator: DotsDecorator(
          size: const Size.square(9.0),
          activeSize: const Size(18.0, 9.0),
          activeShape:
              RoundedRectangleBorder(borderRadius: BorderRadius.circular(5.0)),
        ),
        onSkip: controller.onToMain,
        onDone: controller.onToMain,
        skip: Text(LocaleKeys.welcomeSkip.tr),
        next: Text(LocaleKeys.welcomeNext.tr),
        done: Text(LocaleKeys.welcomeStart.tr),
        showSkipButton: true,
        pages: [
          PageViewModel(
            decoration: pd,
            title: LocaleKeys.welcomeOneTitle.tr,
            body: LocaleKeys.welcomeOneDesc.tr,
            image: ImageWidget.asset(AssetsImages.welcome_1Png),
          ),
          PageViewModel(
            decoration: pd,
            title: LocaleKeys.welcomeTwoTitle.tr,
            body: LocaleKeys.welcomeTwoDesc.tr,
            image: ImageWidget.asset(AssetsImages.welcome_2Png),
          ),
          PageViewModel(
            decoration: pd,
            title: LocaleKeys.welcomeThreeTitle.tr,
            body: LocaleKeys.welcomeThreeDesc.tr,
            image: ImageWidget.asset(AssetsImages.welcome_3Png),
          ),
        ]);
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<WelcomeController>(
      init: WelcomeController(),
      id: "welcome",
      builder: (_) {
        return Scaffold(
          body: SafeArea(
            child: _buildView(),
          ),
        );
      },
    );
  }
}
