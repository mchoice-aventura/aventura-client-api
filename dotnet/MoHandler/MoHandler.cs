 
 /*
 *   (C) Copyright 2009-2010 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 */
using System;
using System.Collections.Generic;
using System.Text;
using System.Web;

namespace MoHandler
{
    public class MoHandler : IHttpHandler
    {       
        public void ProcessRequest(HttpContext context)
        {
            HttpRequest Request = context.Request;
            HttpResponse Response = context.Response;           
            Response.Write("<html>");
            Response.Write("<body>");
            Response.Write("<h1> Hello from MO handler. </h1>");
            Response.Write("<h1> correlator is :" + Request.Form.Get("correlator").ToString() + "</h1>");
            Response.Write("<h1> addresss is : " +Request.Form.Get("address").ToString() + "</h1>");
            Response.Write("<h1> message  is : " + Request.Form.Get("message").ToString() + "</h1>");
            Response.Write("</body>");
            Response.Write("</html>");         
        }
        public bool IsReusable
        {
            get { return false; }
        }      
            
    }
}
