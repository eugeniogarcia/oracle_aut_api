String strbody = (String)context.getServiceResponse().getBody().asString()

def headerStr = "";
try
{
  int spanPos = strbody.indexOf("x-b3-traceid")
  int fstquote = strbody.indexOf(":", spanPos)
  int sndquote = strbody.indexOf(",", fstquote)
  headerStr = strbody.substring(0, fstquote) + ":\"xxx\"" + strbody.substring(sndquote)
}
catch (Exception err)
{
  headerStr = strbody+ "doh";
}
def aBody = new StringBodyImpl(headerStr, " application/json")
context.getApiResponse().setBody(aBody)
