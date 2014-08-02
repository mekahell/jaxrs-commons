package io.mika.rs;

import org.apache.avro.generic.GenericContainer;
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

import static io.mika.rs.MediaType.AVRO_BINARY;

/**
 * Created by mickael on 02/08/14.
 */
@Provider
@Consumes(AVRO_BINARY)
public class AvroMessageBodyReader implements MessageBodyReader<GenericContainer> {

    private static final Logger LOG = LoggerFactory.getLogger(AvroMessageBodyReader.class);

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("isReadable : type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    type, genericType, annotations, mediaType);
        }
        return false;
    }

    @Override
    public GenericContainer readFrom(Class<GenericContainer> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String,String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("readFrom : type : {}, genericType : {}, annotations : {}, mediaType : {}",
                    type, genericType, annotations, mediaType);
        }
        return null;
    }
}
