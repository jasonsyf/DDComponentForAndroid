package com.mrzhang.andcomponent.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.mrzhang.andcomponent.DownLoadActivity;
import com.mrzhang.component.componentlib.router.ui.IComponentRouter;

/**
 * Created by Jason_Sunyf on 2017/10/25 0025.
 * Email： jason_sunyf@163.com
 */

public class DownLoadUIRoute  implements IComponentRouter {

    private static final String SCHME = "componentdemo";
    private static final String DOWNLOADHOST = "download";
    private static String[] HOSTS = new String[]{DOWNLOADHOST};

    public static DownLoadUIRoute getInstance() {
        return instance;
    }

    private static DownLoadUIRoute instance=new DownLoadUIRoute();

    public DownLoadUIRoute() {
    }

    @Override
    public boolean openUri(Context context, String url, Bundle bundle) {
        //判断url以及context是否为空  是空说明已经注册组件
        if (TextUtils.isEmpty(url) || context == null) {
            return true;
        }
        //否则的话就注册权限
        return openUri(context, Uri.parse(url), bundle);
    }

    @Override
    public boolean openUri(Context context, Uri uri, Bundle bundle) {
        if (uri == null || context == null) {
            return true;
        }
        String host = uri.getHost();
        if (DOWNLOADHOST.equals(host)) {
            Intent intent = new Intent(context, DownLoadActivity.class);
            intent.putExtras(bundle == null ? new Bundle() : bundle);
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyUri(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (SCHME.equals(scheme)) {
            for (String str : HOSTS) {
                if (str.equals(host)) {
                    return true;
                }
            }
        }
        return false;
    }
}
