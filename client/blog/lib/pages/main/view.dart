import 'package:blog/common/index.dart';
import 'package:blog/pages/index.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:line_icons/line_icons.dart';
import 'package:salomon_bottom_bar/salomon_bottom_bar.dart';

class MainPage extends StatefulWidget {
  const MainPage({Key? key}) : super(key: key);

  @override
  State<MainPage> createState() => _MainPageState();
}

class _MainPageState extends State<MainPage>
    with AutomaticKeepAliveClientMixin {
  @override
  bool get wantKeepAlive => true;

  @override
  Widget build(BuildContext context) {
    super.build(context);
    return const _MainViewGetX();
  }
}

class _MainViewGetX extends GetView<MainController> {
  const _MainViewGetX({Key? key}) : super(key: key);

  // 主视图
  Widget _buildView() {
    DateTime? _lastPressedAt;
    return WillPopScope(
      // 防止连续点击两次退出
      onWillPop: () async {
        if (_lastPressedAt == null ||
            DateTime.now().difference(_lastPressedAt!) >
                const Duration(seconds: 1)) {
          _lastPressedAt = DateTime.now();
          Loading.toast('Press again to exit');
          return false;
        }
        await SystemChannels.platform.invokeMethod('SystemNavigator.pop');
        return true;
      },
      child: Scaffold(
        extendBody: true,
        resizeToAvoidBottomInset: false,
        // 导航栏
        bottomNavigationBar: GetBuilder<MainController>(
          id: 'navigation',
          builder: (controller) {
            return SalomonBottomBar(
              currentIndex: controller.currentIndex,
              items: [
                SalomonBottomBarItem(
                  title: Text(LocaleKeys.tabBarHome.tr),
                  icon: Icon(LineIcons.home),
                ),
                SalomonBottomBarItem(
                  title: Text(LocaleKeys.tabBarBlog.tr),
                  icon: Icon(LineIcons.blog),
                ),
                SalomonBottomBarItem(
                  title: Text(LocaleKeys.tabBarBox.tr),
                  icon: Icon(LineIcons.toolbox),
                ),
                SalomonBottomBarItem(
                  title: Text(LocaleKeys.tabBarProfile.tr),
                  icon: Icon(LineIcons.user),
                )
              ],
              onTap: controller.onJumpToPage,
              // 切换tab事件
            );
          },
        ),
        // 内容页
        body: PageView(
          physics: const ScrollPhysics(),
          controller: controller.pageController,
          onPageChanged: controller.onIndexChanged,
          children: const [
            // 加入空页面占位
            Text("1"),
            Text("2"),
            Text("3"),
            MinePage(),
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<MainController>(
      init: MainController(),
      id: "main",
      builder: (_) {
        return Scaffold(
          appBar: AppBar(title: const Text("main")),
          body: SafeArea(
            child: _buildView(),
          ),
        );
      },
    );
  }
}
