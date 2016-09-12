package oysd.com.rxandroid_mvp_demo.View;

/**
 * Created by ouyangshengduo on 2016/9/12.
 */
public interface UserView {

    void showPic(byte[] data);
    void showProgressDialog();
    void hideProgressDialog();
    void showError(String msg);

}
