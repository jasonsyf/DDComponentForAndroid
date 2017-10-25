package com.mrzhang.andcomponent.applike;

import com.mrzhang.andcomponent.route.DownLoadUIRoute;
import com.mrzhang.component.componentlib.applicationlike.IApplicationLike;
import com.mrzhang.component.componentlib.router.ui.UIRouter;

/**
 * Created by Jason_Sunyf on 2017/10/25 0025.
 * Email： jason_sunyf@163.com
 */

public class DownloadAppLike implements IApplicationLike {
    UIRouter mUIRouter = UIRouter.getInstance();
    DownLoadUIRoute mDownLoadUIRoute = DownLoadUIRoute.getInstance();

    @Override
    public void onCreate() {
        mUIRouter.registerUI(mDownLoadUIRoute);
    }

    @Override
    public void onStop() {
         mUIRouter.unregisterUI(mDownLoadUIRoute);
    }
}
