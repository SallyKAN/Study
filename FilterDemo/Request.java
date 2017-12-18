
/**
 * Created by v_kangjiayuan on 2017/12/18.
 */
public class Request {
    StringBuffer content;

    public Request() {

        content = new StringBuffer("request");

    }

    public Request(StringBuffer content){

        this.content = new StringBuffer(content);

    }

    public StringBuffer getContent() {

        return content;

    }

    public void setContent(StringBuffer content) {

        this.content = new StringBuffer(content);

    }

    public void append(String append){

        this.content.append(append);

    }

}
