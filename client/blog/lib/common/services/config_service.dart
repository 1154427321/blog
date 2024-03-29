import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:package_info_plus/package_info_plus.dart';

import '../index.dart';

/// 配置服务
class ConfigService extends GetxService {
  // 这是一个单例写法
  static ConfigService get inject => Get.find();

  PackageInfo? _platform;

  String get version => _platform?.version ?? '-';

  Locale locale = PlatformDispatcher.instance.locale;

  // 初始化
  Future<ConfigService> init() async {
    // 获取平台信息
    await getPlatform();
    // 初始化语言
    initLocale();
    return this;
  }
  Future<void> getPlatform() async {
    _platform = await PackageInfo.fromPlatform();
  }



  // 是否首次打开
  bool get isAlreadyOpen => Storage().getBool(Constants.storageAlreadyOpen);

  // 标记已打开app
  void setAlreadyOpen() {
    Storage().setBool(Constants.storageAlreadyOpen, true);
  }



  // 初始语言
  void initLocale() {
    var langCode = Storage().getString(Constants.storageLanguageCode);
    if (langCode.isEmpty) return;
    var index = Translation.supportedLocales.indexWhere((element) {
      return element.languageCode == langCode;
    });
    if (index < 0) return;
    locale = Translation.supportedLocales[index];
  }

  // 更改语言
  void onLocaleUpdate(Locale value) {
    locale = value;
    // 更新语言
    Get.updateLocale(value);
    // 保存语言至kv存储
    Storage().setString(Constants.storageLanguageCode, value.languageCode);
  }



  // 主题
  final RxBool _isDarkModel = Get.isDarkMode.obs;

  bool get isDarkModel => _isDarkModel.value;

  // 切换 theme
  Future<void> switchThemeModel() async {
    _isDarkModel.value = !_isDarkModel.value;
    Get.changeTheme(
      _isDarkModel.value == true ? AppTheme.dark : AppTheme.light,
    );
    await Storage().setString(Constants.storageThemeCode,
        _isDarkModel.value == true ? "dark" : "light");
  }

  // 初始 theme
  void initTheme() {
    var themeCode = Storage().getString(Constants.storageThemeCode);
    _isDarkModel.value = themeCode == "dark" ? true : false;
    Get.changeTheme(
      themeCode == "dark" ? AppTheme.dark : AppTheme.light,
    );
  }
}

