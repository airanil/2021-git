<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Spring boot send mail example</title>
  </head>
  <body>
  	<div>
  		<h4>Hi ${data.fullName},</h4>
  	</div>
  	<div style="padding-left:10px; font-size:18px;">${data.emailTemplateHeaderMessage}</div>
  	<div style="margin-top:5px; font-size:15px">
  		<table>
  			<tr>
  				<td>AWB Number</td>
  				<td>:</td>
  				<td>${data.awb}</td>
  			</tr>
  			<tr>
  				<td>AWB Suffix</td>
  				<td>:</td>
  				<td>${data.awbSfx}</td>
  			</tr>
  			<#if (data.hawb)?has_content>
     			<tr>
  					<td>HAWB</td>
  					<td>:</td>
  					<td>${data.hawb}</td>
  				</tr>
     		</#if>
     		<tr>
  				<td>Origin</td>
  				<td>:</td>
  				<td>${data.origin}</td>
  			</tr>
  			<tr>
  				<td>Destination</td>
  				<td>:</td>
  				<td>${data.destination}</td>
  			</tr>
  			<tr>
  				<td>Pieces</td>
  				<td>:</td>
  				<td>${data.pieces}</td>
  			</tr>
  			<tr>
  				<td>Weight</td>
  				<td>:</td>
  				<td>${data.weight}</td>
  			</tr>
  			<tr>
  				<td>Flight Key</td>
  				<td>:</td>
  				<td>${data.flightKey}</td>
  			</tr>
  			<tr>
  				<td>Flight Date</td>
  				<td>:</td>
  				<td>${data.flightDate}</td>
  			</tr>
  			<tr>
  				<td>Request Status</td>
  				<td>:</td>
  				<td>${data.reqStatus}</td>
  			</tr>
  			<#if (data.plp)?has_content>
  				<tr>
  					<td>PLP</td>
  					<td>:</td>
  					<td>${data.plp}</td>
  				</tr>
  			</#if>
  			<#if (data.awbRelease)?has_content>
  				<tr>
  					<td>AWB Released</td>
  					<td>:</td>
  					<td>
  						<#assign awbReleased = data.awbRelease>
  						<#if awbReleased == "Y">
  							YES
  						<#else>
  							NO
  						</#if>
  					</td>
  				</tr>
  			</#if>
  			<#if (data.releaseDocNo)?has_content>
  				<tr>
  					<td>Release Document No</td>
  					<td>:</td>
  					<td>${data.releaseDocNo}</td>
  				</tr>
  			</#if>
  			<#if (data.ddo)?has_content>
  				<tr>
  					<td>DDO No</td>
  					<td>:</td>
  					<td>${data.ddo}</td>
  				</tr>
  			</#if>
  			<#if (data.docType)?has_content>
  				<tr>
  					<td>Doc Type</td>
  					<td>:</td>
  					<td>${data.docType}</td>
  				</tr>
  			</#if>
  			<#if (data.pibLetterNo)?has_content>
  				<tr>
  					<td>PIB Letter No</td>
  					<td>:</td>
  					<td>${data.pibLetterNo}</td>
  				</tr>
  			</#if>
  			<#if (data.pibLetterDate)?has_content>
  				<tr>
  					<td>PIB Letter Date</td>
  					<td>:</td>
  					<td>${data.pibLetterDate}</td>
  				</tr>
  			</#if>
  			<#if (data.spbbLetterNo)?has_content>
  				<tr>
  					<td>SPBB Letter No</td>
  					<td>:</td>
  					<td>${data.spbbLetterNo}</td>
  				</tr>
  			</#if>
  			<#if (data.spbbLetterDate)?has_content>
  				<tr>
  					<td>SPBB Letter Date</td>
  					<td>:</td>
  					<td>${data.spbbLetterDate}</td>
  				</tr>
  			</#if>
  			<#if (data.chargeWt) gt 0>
  				<tr>
  					<td>Charge Weight</td>
  					<td>:</td>
  					<td>${data.chargeWt}</td>
  				</tr>
  			</#if>
  			<#if (data.paymentType)?has_content>
  				<tr>
  					<td>Payment Type</td>
  					<td>:</td>
  					<td>${data.paymentType}</td>
  				</tr>
  			</#if>
  			<#if (data.payPlanDate)?has_content>
  				<tr>
  					<td>Pay Plan Date</td>
  					<td>:</td>
  					<td>${data.payPlanDate}</td>
  				</tr>
  			</#if>
  			<#if (data.totalPaidAmt) gt 0>
  				<tr>
  					<td>Total Amount Paid</td>
  					<td>:</td>
  					<td>${data.totalPaidAmt}</td>
  				</tr>
  			</#if>
  			<#if (data.proInvoiceNo)?has_content>
  				<tr>
  					<td>Performa Invoice No</td>
  					<td>:</td>
  					<td>${data.proInvoiceNo}</td>
  				</tr>
  			</#if>
  			<#if (data.customDocStatus)?has_content>
  				<tr>
  					<td>Custom Doc Status</td>
  					<td>:</td>
  					<td>${data.customDocStatus}</td>
  				</tr>
  			</#if>
  			<#if (data.releaseCdoNo)?has_content>
  				<tr>
  					<td>Release CDO No</td>
  					<td>:</td>
  					<td>${data.releaseCdoNo}</td>
  				</tr>
  			</#if>
  			<#if (data.ddoNo)?has_content>
  				<tr>
  					<td>DDO No</td>
  					<td>:</td>
  					<td>${data.ddoNo}</td>
  				</tr>
  			</#if>
  			<#if (data.requestDate)?has_content>
  				<tr>
  					<td>Request Date</td>
  					<td>:</td>
  					<td>${data.requestDate}</td>
  				</tr>
  			</#if>
  			<#if (data.customerName)?has_content>
  				<tr>
  					<td>Customer Name</td>
  					<td>:</td>
  					<td>${data.customerName}</td>
  				</tr>
  			</#if>
  			<#if (data.customerAddress)?has_content>
  				<tr>
  					<td>Customer Address</td>
  					<td>:</td>
  					<td>${data.customerAddress}</td>
  				</tr>
  			</#if>
  			<#if (data.reason)?has_content>
  				<tr>
  					<td>Remarks</td>
  					<td>:</td>
  					<td>${data.reason}</td>
  				</tr>
  			</#if>

  		</table>
  	</div>
  	<div style="margin-top:5px;">
  		<h5>Encl: PDF </h5>
  	</div>
  	<div style="margin-top:10px;">
  		<div>
  		  	<h4>Thanks & Regards,</h4>
  			<h4>PTJAS Team</h4>
  		</div>
  	</div>
  </body>
 </html>