class UserProfile {
  String? id;
  String? createUser;
  DateTime? updateTime;
  String? updateUser;
  String?mark;
  String?account;
  String?password;
  String?mail;
  String?phone;
  String?photo;
  String?introduction;
  DateTime?createTime;

  String? token;


  UserProfile({
      this.id, 
      this.createUser, 
      this.updateTime, 
      this.updateUser,
      this.mark,
      this.account, 
      this.password, 
      this.mail, 
      this.phone, 
      this.photo, 
      this.introduction, 
      this.createTime,
    this.token,});

  UserProfile.fromJson(dynamic json) {
    id = json['data']['userInfo']['id'];
    createUser = json['data']['userInfo']['createUser'];
    updateTime = DateTime.parse(json['data']['userInfo']['updateTime']);
    updateUser = json['data']['userInfo']['updateUser'];
    mark = json['data']['userInfo']['mark'];
    account = json['data']['userInfo']['account'];
    password = json['data']['userInfo']['password'];
    mail = json['data']['userInfo']['mail'];
    phone = json['data']['userInfo']['phone'];
    photo = json['data']['userInfo']['photo'];
    introduction = json['data']['userInfo']['introduction'];
    createTime = DateTime.parse(json['data']['userInfo']['createTime']);
    token = json['data']['token'];
  }


  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['createUser'] = createUser;
    map['updateTime'] = updateTime;
    map['updateUser'] = updateUser;
    map['mark'] = mark;
    map['account'] = account;
    map['password'] = password;
    map['mail'] = mail;
    map['phone'] = phone;
    map['photo'] = photo;
    map['introduction'] = introduction;
    map['createTime'] = createTime;

    return map;
  }

}