import 'package:flutter/material.dart';
import 'package:get/get.dart';

class MainController extends GetxController {
  MainController();
  //分页控制器
  final PageController pageController = PageController();

  // 当前的 tab index
  int currentIndex = 0;
  _initData() {
    update(["main"]);
  }

  // 导航栏切换
  void onIndexChanged(int index) {
    currentIndex = index;
    update(['navigation']);
  }

  // 切换页面
  void onJumpToPage(int page) {
    // 滚动到指定页面并显示滑动动画
    pageController.animateToPage(
      page, // 滚动到指定页面
      duration: Duration(milliseconds: 500), // 动画持续时间
      curve: Curves.ease, // 动画曲线
    );
  }

  void onTap() {}

  // @override
  // void onInit() {
  //   super.onInit();
  // }

  @override
  void onReady() {
    super.onReady();
    _initData();
  }

  @override
  void onClose() {
    super.onClose();
    pageController.dispose();
  }
}
