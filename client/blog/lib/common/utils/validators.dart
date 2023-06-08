import 'package:blog/common/index.dart';
import 'package:get/get.dart';
///用于自定义表单验证
class Validators {

  ///验证用户名
  static String? usernameValidator(String? value) {
    if (value == null || value.isEmpty || !RegExp(r'^[a-zA-Z0-9_]{3,16}$').hasMatch(value)) {
      return LocaleKeys.loginValidNameHint.tr;
    }
    return null;
  }
}
