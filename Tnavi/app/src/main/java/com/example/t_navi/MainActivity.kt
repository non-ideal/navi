package com.example.t_navi

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.navi.Constants
import com.kakao.sdk.navi.NaviClient
import com.kakao.sdk.navi.model.CoordType
import com.kakao.sdk.navi.model.Location
import com.kakao.sdk.navi.model.NaviOption
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val keyhash = Utility.getKeyHash(context = this)
        println("keyhash= $keyhash")
        // 카카오내비 앱으로 길 안내

        // 카카오내비 앱으로 길 안내
        if (NaviClient.instance.isKakaoNaviInstalled(getApplicationContext())) {
            // 카카오내비 앱으로 길 안내 - WGS84
            startActivity(
                NaviClient.instance.navigateIntent(
                    Location("카카오 판교오피스", "127.108640", "37.402111"),
                    NaviOption(coordType = CoordType.WGS84)
                )
            )
        } else {
            // 카카오내비 설치 페이지로 이동
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(Constants.WEB_NAVI_INSTALL)
                ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
        }

        KakaoSdk.init(this, "{759ac0fbd24eb7e2ab0f15dfdfadad0b}")




    }



}