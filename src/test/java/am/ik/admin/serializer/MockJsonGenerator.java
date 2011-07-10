package am.ik.admin.serializer;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.ObjectCodec;

public class MockJsonGenerator extends JsonGenerator {

    private PrintWriter writer;

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public JsonGenerator enable(Feature f) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public JsonGenerator disable(Feature f) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public boolean isEnabled(Feature f) {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public JsonGenerator setCodec(ObjectCodec oc) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public ObjectCodec getCodec() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public JsonGenerator useDefaultPrettyPrinter() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public void writeStartArray() throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeEndArray() throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeStartObject() throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeEndObject() throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeFieldName(String name) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeString(String text) throws IOException,
            JsonGenerationException {
        writer.print(text);
        writer.flush();
    }

    @Override
    public void writeString(char[] text, int offset, int len)
            throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRawUTF8String(byte[] text, int offset, int length)
            throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeUTF8String(byte[] text, int offset, int length)
            throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRaw(String text) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRaw(String text, int offset, int len) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRaw(char[] text, int offset, int len) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRaw(char c) throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRawValue(String text) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRawValue(String text, int offset, int len)
            throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeRawValue(char[] text, int offset, int len)
            throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeBinary(Base64Variant b64variant, byte[] data, int offset,
            int len) throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(int v) throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(long v) throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(BigInteger v) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(double d) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(float f) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(BigDecimal dec) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNumber(String encodedValue) throws IOException,
            JsonGenerationException, UnsupportedOperationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeBoolean(boolean state) throws IOException,
            JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeNull() throws IOException, JsonGenerationException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeObject(Object pojo) throws IOException,
            JsonProcessingException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void writeTree(JsonNode rootNode) throws IOException,
            JsonProcessingException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void copyCurrentEvent(JsonParser jp) throws IOException,
            JsonProcessingException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void copyCurrentStructure(JsonParser jp) throws IOException,
            JsonProcessingException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public JsonStreamContext getOutputContext() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public void flush() throws IOException {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public boolean isClosed() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public void close() throws IOException {
        // TODO 自動生成されたメソッド・スタブ

    }

}
