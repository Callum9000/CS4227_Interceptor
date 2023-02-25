package interceptor;

import java.util.ArrayList;

public class dispatcher {
    ArrayList<concreteInterceptor> intercept;

    public dispatcher() {
        intercept = new ArrayList<concreteInterceptor>();
    }

    public void attach(concreteInterceptor CI) {
        intercept.add(CI);
    }

    public void detach(concreteInterceptor CI) {
        intercept.remove(CI);
    }

    public void dispatchRent(contextObject CO) {
        for (concreteInterceptor i : intercept) {
            i.interceptRented(CO);
            ;
        }
    }

    public void dispatchFRP(contextObject CO) {
        for (concreteInterceptor i : intercept) {
            i.interceptFRP(CO);
            ;
        }
    }

}
