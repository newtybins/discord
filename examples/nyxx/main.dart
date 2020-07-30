import 'dart:io';

import 'package:nyxx/Vm.dart';
import 'package:nyxx/nyxx.dart';

void main() {
  // Create an instance of the bot!
  final bot = NyxxVm(Platform.environment['your-super-secret-token']);

  // When I am ready, inform the developer through the logs!
  bot.onReady.listen((e) => print('I am ready!'));

  // When a message is sent to a channel - and if the content of
  // the message is ping, reply with pong!
  bot.onMessageReceived.listen((MessageEvent e) {
    if (e.message.content == "ping") {
      e.message.channel.send(content: "pong!");
    }
  });
}