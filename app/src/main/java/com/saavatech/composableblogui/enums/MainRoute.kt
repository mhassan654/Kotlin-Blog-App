package com.saavatech.composableblogui.enums

enum class MainRoute(value: String) {
    About("about"),
    Settings("settings"),
    Profile("profile"),
    Splash("splash"),
    Login("login"),
    PostDetails("post_details/{post_id}"),
}