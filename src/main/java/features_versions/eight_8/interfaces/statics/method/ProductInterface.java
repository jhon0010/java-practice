package features_versions.eight_8.interfaces.statics.method;

/**
 * It can't be overridden by an implementing class.
 *
 * You can access to it in the same way that you access to other static methods.
 *
 * ProductInterface.getCompanyName
 *
 */
public interface ProductInterface {

    static String getCompanyName(){
        return "Company Name From static";
    }
}
