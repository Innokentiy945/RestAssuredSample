package Builder;

import Model.PayloadBody;
import URI.Url;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Builder {

    public static RequestSpecification getBuilder() {
        RequestSpecBuilder requestSpec = new RequestSpecBuilder()
                .setBaseUri(Url.MAIN_URL + Url.EVENTS_GET)
                .setContentType(Url.CONTENT_TYPE);
        return requestSpec.build();
    }

    public static RequestSpecification postBuilder(String title, String description) {
        RequestSpecBuilder requestSpec = new RequestSpecBuilder()
                .setBaseUri(Url.MAIN_URL + Url.EVENTS_POST)
                .setBody(PayloadBody.dataFromModel(title, description))
                .setContentType(Url.CONTENT_TYPE);
        return requestSpec.build();
    }

    public static RequestSpecification putBuilder(String numId, String title, String description) {
        RequestSpecBuilder requestSpec = new RequestSpecBuilder()
                .setBaseUri(Url.MAIN_URL + Url.EVENTS_PUT + numId)
                .setBody(PayloadBody.dataFromModel(title, description))
                .setContentType(Url.CONTENT_TYPE);
        return requestSpec.build();
    }

    public static RequestSpecification deleteBuilder(String numId, String title, String description) {
        RequestSpecBuilder requestSpec = new RequestSpecBuilder()
                .setBaseUri(Url.MAIN_URL + Url.EVENTS_DELETE + numId)
                .setBody(PayloadBody.dataFromModel(title, description))
                .setContentType(Url.CONTENT_TYPE);
        return requestSpec.build();
    }
}
