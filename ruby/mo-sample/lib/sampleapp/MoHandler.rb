#/*
# *   (C) Copyright 2010-2011 hSenid Software International (Pvt) Limited.
# *   All Rights Reserved.
# *
# *   These materials are unpublished, proprietary, confidential source code of
# *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
# *   of hSenid Software International (Pvt) Limited.
# *
# *   hSenid Software International (Pvt) Limited retains all title to and intellectual
# *   property rights in these materials.
# *
# */


#!/sw/bin/ruby
require 'webrick'
require 'net/http'
require 'uri'
include WEBrick

#  $LastChangedDate$
#  $LastChangedBy$
#  $LastChangedRevision$

class MoHandler  < WEBrick::HTTPServlet::AbstractServlet
   def do_POST(request, response)
      response.body = "<HTML>" + "\n"
      response.body << "<Head>" + "\n"
      response.body << "message is : " + request.query['message'] + "\n"
      response.body << "address is : " + request.query['address'] + "\n"
      response.body << "correlator is : " + request.query['correlator'] + "\n"
      response.body << "</Head>" + "\n"
      response.body << "</HTML>" + "\n"
   end
end

# ----------------------------------------------
# Create an HTTP server
s = HTTPServer.new(
  :Port            => 8002
)
s.mount("/MoHandler", MoHandler)
# When the server gets a control-C, kill it
trap("INT"){ s.shutdown }
# Start the server
s.start
s.listeners