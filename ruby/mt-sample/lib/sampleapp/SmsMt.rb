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

require 'net/http'
require 'uri'
require 'base64'

#  $LastChangedDate$
#  $LastChangedBy$
#  $LastChangedRevision$

   uri = URI.parse("http://localhost:65182/")
   http = Net:: HTTP.new(uri.host, uri.port)
   request = Net:: HTTP:: Get.new(uri.request_uri)
   request.set_form_data({"address" => "tel:1212121212", "message" => "hi all", "version" => "1.0"})
   request.basic_auth(Base64::encode64("PD_ET_e0550"),
   Base64::encode64("098f6bcd4621d373cade4e832627b4f6"))
   response = http.request(request)
   puts response.body

