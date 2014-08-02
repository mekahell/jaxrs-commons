package io.mika.rs;

import com.google.protobuf.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static io.mika.rs.MediaType.APPLICATION_PROTOBUF;

/**
 * Created by mickael on 26/07/14.
 */
@Provider
@Consumes(APPLICATION_PROTOBUF)
public class ProtobufMessageBodyReader implements MessageBodyReader<Message> {

    private static final Logger LOG = LoggerFactory.getLogger(ProtobufMessageBodyReader.class);

    @Override
    public boolean isReadable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("isReadable : type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    type, genericType, annotations, mediaType);
        }
        return false;
    }

    @Override
    public Message readFrom(Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("readFrom : type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    type, genericType, annotations, mediaType);
        }
        return null;
    }
}
