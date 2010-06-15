
using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Net;
using System.IO;
using System.Text;


public class MtMessageSender
{
    private string address;
    private string message;
    private string appId = "PD_ET_e0550";
    private string password = "098f6bcd4621d373cade4e832627b4f6";

    public MtMessageSender(string address, string message)
    {
        this.address = address;
        this.message = message;
    }
    public string sendMessage()
    {
        ASCIIEncoding encoding = new ASCIIEncoding();
        Byte[] userPassBytes = encoding.GetBytes(String.Format("{0}:{1}", appId, password));
        String authHeader = "Authorization: Basic " + (Convert.ToBase64String(userPassBytes));
        string postData = "version=1.0" + "&address=" + address + "&message=" + message;
        byte[] byteArray = encoding.GetBytes(postData);
        WebRequest request = WebRequest.Create("http://192.168.0.250:65182/");
        request.Headers.Add(authHeader);
        request.Method = "POST";
        request.ContentType = "application/x-www-form-urlencoded";
        request.ContentLength = byteArray.Length;
        Stream dataStream = request.GetRequestStream();
        dataStream.Write(byteArray, 0, byteArray.Length);
        dataStream.Close();
        WebResponse response = request.GetResponse();
        Console.WriteLine(((HttpWebResponse)response).StatusDescription);
        dataStream = response.GetResponseStream();
        StreamReader reader = new StreamReader(dataStream);
        string responseFromServer = reader.ReadToEnd();
        reader.Close();
        dataStream.Close();
        response.Close();
        return responseFromServer;
    }
}
