var casper = require('casper').create();
var elements;
casper.start('http://goindonesia.com/id/hotels/indonesia/jawa/jakarta', function() {
	if (this.exists('#itemContainer > li > div > div.hotel-attributes-gi')) {
		elements= this.evaluate(function() {
			   var el=__utils__.findAll('#itemContainer > li > div > div.hotel-attributes-gi');
					return [].map.call(el, function(element) {
						var a='{"hotel":"'+element.children[0].children[0].innerHTML+'","price":'+element.children[2].children[3].getAttribute('data-room-price')+'}';
					return a;
				});	
		});
		this.echo(JSON.parse(JSON.stringify('['+elements+']')));
		//this.echo('elements');
	}else{
		this.echo('not elements');
	}	
});

casper.run(
function(){
	
	casper.exit();
}
);
