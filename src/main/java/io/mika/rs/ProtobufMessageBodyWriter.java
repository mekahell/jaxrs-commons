package io.mika.rs;

import com.google.protobuf.Message;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import static io.mika.rs.MediaType.APPLICATION_PROTOBUF;

/**
 * Created by mickael on 26/07/14.
 */
@Provider
@Produces(APPLICATION_PROTOBUF)
public class ProtobufMessageBodyWriter implements MessageBodyWriter<Message> {

    @Override
    public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Message.class.isAssignableFrom(type);
    }

    private Map<Object, byte[]> buffer = new WeakHashMap<Object, byte[]>();

    private byte[] toByteArray(final Message m) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        m.writeTo(baos);
        return baos.toByteArray();
    }

    @Override
    public long getSize(Message m, Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        try {
            byte[] bytes = toByteArray(m);
            buffer.put(m, bytes);
            return bytes.length;
        } catch (IOException e) {
            return -1;
        }
    }

    @Override
    public void writeTo(Message m, Class type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap httpHeaders, OutputStream entityStream)
            throws IOException, WebApplicationException {
        if (buffer.containsKey(m)) {
            entityStream.write(buffer.remove(m));
        }
        else {
            entityStream.write(toByteArray(m));
        }
    }
}
