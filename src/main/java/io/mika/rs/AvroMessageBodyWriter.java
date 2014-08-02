package io.mika.rs;

import org.apache.avro.generic.GenericContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static io.mika.rs.MediaType.AVRO_BINARY;

/**
 * Created by mickael on 02/08/14.
 */
@Provider
@Produces(AVRO_BINARY)
public class AvroMessageBodyWriter implements MessageBodyWriter<GenericContainer> {

    private static final Logger LOG = LoggerFactory.getLogger(AvroMessageBodyWriter.class);

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("isWriteable : type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    type, genericType, annotations, mediaType);
        }
        return GenericContainer.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(GenericContainer gc, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getSize : t {}, type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    gc, type, genericType, annotations, mediaType);
        }
        return 0;
    }

    @Override
    public void writeTo(GenericContainer gc, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> headers, OutputStream outputStream) throws IOException, WebApplicationException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("writeTo : t {}, type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    gc, type, genericType, annotations, mediaType);
        }
    }
}
