<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Spring boot send mail example</title>
  </head>
  <body>
  	<div>
  		<h4>Hello ${data.fullName},</h4>
  	</div>
  	<div style="padding-left:10px; font-size:19px;">We get it, ${data.username} - you forgot your password. We can't wait for you to get back online.</div>
  	
  	<div style="margin-top:10px; padding-left:10px; font-size:19px;">Here is the password ${data.password}</div>
  
  	<div style="margin-top:15px; padding-left:10px; font-size:16px;">P.S. If you did not request a password reset, or are having any trouble logging in, please let us know at https://www.ptjas.co.id/</div>

	<div style="margin-top:10px;">
  		<div>
  		  	<h3>Thanks & Regards,</h3>
  			<h3>Test Team</h3>
  		</div>
  	</div>
  
  </body>
 </html>