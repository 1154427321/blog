import 'package:blog/common/index.dart';

/// 用户 api
class UserApi {
  /// 登录
  static Future<UserProfile?> login(UserLoginReq? req) async {
    var res = await ApiService.inject.post(
      '/auth/accountLogin',
      data: req,
    );
    if (res.data['code'] == 200) {
      return UserProfile.fromJson(res.data);
    } else return null;
  }


  /// 登录
  static Future<UserProfile?> register(UserLoginReq? req) async {
    var res = await ApiService.inject.post(
      '/auth/accountRegister',
      data: req,
    );
    if (res.data['code'] == 200) {
      return UserProfile.fromJson(res.data);
    } else return null;
  }
}
