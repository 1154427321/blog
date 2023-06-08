import 'package:blog/common/index.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

import 'index.dart';

class StylesPage extends GetView<StylesController> {
  const StylesPage({Key? key}) : super(key: key);

  // 主视图
  Widget _buildView() {
      return ListView(
        children: [
          ListTile(
            onTap: controller.onThemeSelected,
            title:
            Text("主题 : ${ConfigService.inject.isDarkModel ? "Dark" : "Light"}"),
          ),
        ],
      );
    }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<StylesController>(
      init: StylesController(),
      id: "styles",
      builder: (_) {
        return Scaffold(
          appBar: AppBar(title: const Text("styles")),
          body: SafeArea(
            child: _buildView(),
          ),
        );
      },
    );
  }
}
