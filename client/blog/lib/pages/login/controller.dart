import 'package:blog/common/services/user_service.dart';
import 'package:flutter_login/flutter_login.dart';
import 'package:get/get.dart';
import 'package:blog/common/index.dart';

class LoginController extends GetxController {
  LoginController();

  _initData() {
    update(["login"]);
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

  // @override
  // void onClose() {
  //   super.onClose();
  // }

  //登录方法
  Future<String?> authUser(LoginData data) async {
    UserProfile? profile = await UserApi.login(
        UserLoginReq(
            account: data.name,
            password: data.password)
    );
    if(profile == null){
      return LocaleKeys.loginFaild.tr;
    }
    UserService.inject.setProfile(profile);
    UserService.inject.setToken(profile.token);

    return null;
  }

  //注册方法
  Future<String?> register(SignupData data) async {
    UserProfile? profile = await UserApi.register(
        UserLoginReq(
            account: data.name,
            password: data.password)
    );
    if(profile == null){
      return LocaleKeys.loginFaild.tr;
    }
    UserService.inject.setProfile(profile);
    UserService.inject.setToken(profile.token);

    return null;
  }

  //todo 忘记密码？
  Future<String> recoverPassword(String name) {
    return Future.delayed(Duration(seconds: 1)).then((_) {
      return '';
    });
  }


}
