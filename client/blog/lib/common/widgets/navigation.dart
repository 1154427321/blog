
import 'package:blog/common/index.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class NavigationItemModel {
  final String label;
  final String icon;
  final int count;

  NavigationItemModel({
    Key? key,
    required this.label,
    required this.icon,
    this.count = 0,
  });
}

class MyNavigationBar extends StatelessWidget {
  //属性
  final int currentIndex;
  final List<NavigationItemModel> items;
  final Function(int) onTap;

  //构造器
  const MyNavigationBar({
    Key? key,
    required this.currentIndex,
    required this.items,
    required this.onTap,
  }) : super(key: key);

  //视图构建
  @override
  Widget build(BuildContext context) {
    var ws = <Widget>[];
    for (var i = 0; i < items.length; i++) {
      //选中为主色，未选中颜色为空
      var color = (i == currentIndex) ? AppColors.primary : null;
      var item = items[i];
      ws.add(
        //按钮：column包含图标和文字
        Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            IconWidget.svg(
              item.icon,
              size: 20,
              color: color,
              badgeString: item.count > 0 ? item.count.toString() : null,
            ).paddingBottom(2),
            TextWidget.body1(
              item.label.tr,
              color: color,
            ),
          ],
        ).onTap(() => onTap(i))
            .expanded(),//弹性布局
      );
    }

    return BottomAppBar(
        color: AppColors.surface,
        child: ws.toRow(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.center,
        )
        //限制高度
            .height(kBottomNavigationBarHeight));
  }
}
