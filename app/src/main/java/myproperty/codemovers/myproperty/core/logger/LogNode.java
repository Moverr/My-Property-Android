package myproperty.codemovers.myproperty.core.logger;

/**
 * Created by Manny on 8/26/2017.
 */

public interface LogNode {
    public void println(int priority, String tag, String msg, Throwable tr);
}
