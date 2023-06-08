import 'package:blog/common/index.dart';
import 'package:flutter/material.dart';
import 'package:flutter_login/flutter_login.dart';
import 'package:get/get.dart';

import 'index.dart';

class LoginPage extends GetView<LoginController> {
  const LoginPage({Key? key}) : super(key: key);

  // 主视图
  Widget _buildView() {
    return FlutterLogin(
      title: LocaleKeys.loginTitle.tr,
      logo: AssetsImages.logoPng,
      theme: LoginTheme(
          primaryColor: AppColors.primary,
          titleStyle:AppTextStyles.headlineSmall
          ),
      onLogin: controller.authUser,
      onSignup: controller.register,
      onRecoverPassword: controller.recoverPassword,
      userType: LoginUserType.email,
      userValidator:Validators.usernameValidator,

      //第三方登录
      // loginProviders: <LoginProvider>[
      //   LoginProvider(
      //     icon: FontAwesomeIcons.google,
      //     label: 'Google',
      //     callback: () async {
      //       debugPrint('start google sign in');
      //       await Future.delayed(loginTime);
      //       debugPrint('stop google sign in');
      //       return null;
      //     },
      //   ),
      //   LoginProvider(
      //     icon: FontAwesomeIcons.facebookF,
      //     label: 'Facebook',
      //     callback: () async {
      //       debugPrint('start facebook sign in');
      //       await Future.delayed(loginTime);
      //       debugPrint('stop facebook sign in');
      //       return null;
      //     },
      //   ),
      //   LoginProvider(
      //     icon: FontAwesomeIcons.linkedinIn,
      //     callback: () async {
      //       debugPrint('start linkdin sign in');
      //       await Future.delayed(loginTime);
      //       debugPrint('stop linkdin sign in');
      //       return null;
      //     },
      //   ),
      //   LoginProvider(
      //     icon: FontAwesomeIcons.githubAlt,
      //     callback: () async {
      //       debugPrint('start github sign in');
      //       await Future.delayed(loginTime);
      //       debugPrint('stop github sign in');
      //       return null;
      //     },
      //   ),
      // ],
      onSubmitAnimationCompleted: () {
        Get.back();
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<LoginController>(
      init: LoginController(),
      id: "login",
      builder: (_) {
        return Scaffold(
          body: SafeArea(
            top: false,
            child: _buildView(),
          ),
        );
      },
    );
  }
}
