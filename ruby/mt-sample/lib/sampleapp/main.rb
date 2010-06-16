# To change this template, choose Tools | Templates
# and open the template in the editor.

#puts "Hello World"
 require 'unicode'

  $KCODE = 'UTF-8'
abc = "abc"
#puts abc.encoding.name  # >> US-ASCII
#putc abc.encode_ascii["eshan"]
#abc.force_encoding("UTF-8")

 u = "\352\260\200\353\202\230\353\213\244".to_u
  u.length           #=> 3
  u.to_a             #=> [44032, 45208, 45796], array of codepoint
  u.inspect          #=> <U+AC00><U+B098><U+B2E4>
  u.to_s             #=> "\352\260\200\353\202\230\353\213\244"
  u.encoding = "EUC-KR"
  u.to_s             #=> "\260\241\263\252\264\331"
  u.to_s("UTF-8")    #=> "\352\260\200\353\202\230\353\213\244"
  u.length           #=> 3
  u = "\260\241\263\252\264\331".to_u("EUC-KR")
  u.inspect          #=> <U+AC00><U+B098><U+B2E4>
  puts u

