package oysd.com.rxandroid_mvp_demo.Presenter;

import oysd.com.rxandroid_mvp_demo.View.UserView;
import oysd.com.rxandroid_mvp_demo.model.UserModel;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ouyangshengduo on 2016/9/12.
 */
public class UserPresenter {

    private UserView userView;
    private UserModel userModel;
    public UserPresenter(UserView userView){
        this.userView = userView;
        userModel = new UserModel();

    }
    public void getUserImage(final String path){
        userView.showProgressDialog();
        userModel.getUserImage(path).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
            @Override
            public void onCompleted() {
                userView.hideProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                userView.showError(e.getMessage());
                userView.hideProgressDialog();
            }

            @Override
            public void onNext(byte[] bytes) {
                userView.showPic(bytes);
            }
        });
    }
}
