
const bnt1 =document.querySelector('.blocks-div-1-p');
const btn2 =document.querySelector('.blocks-div-2-p');
const btn3 =document.querySelector('.blocks-div-3-p');
const paragraphHeader = document.querySelector('.center-h3-1');
const paragraphCenter1 = document.querySelector('.center-text-1');
const paragraphCenter2 = document.querySelector('.center-text-2');
const paragraphCenter3 = document.querySelector('.center-text-3');
const paragraphDown = document.querySelector('.center-p-text-1');
const img = document.querySelector('.img-center-1');
const link1 = document.querySelector('.center-a-1');
const heading1 = 'Cloud Servers';
const heading2 = 'Private Cloud';
const heading3 = 'Managed Databases';
const btn1Text1 = 'Our Cloud Servers offer high-performance and resilient cloud with no upfront costs or commitments required. Create new server instances in seconds and scale existing resources with minimal downtime, our public cloud has you covered.' ;
const btn1Text2 = 'Get started quick and easy with the resources you need, then scale up in just a couple of clicks as your business grows. No need to overprovision services with unnecessary capacity, flexibility comes as standard.';
const btn1Text3 = '';
const btn2Text1 = 'If you want true exclusivity, enjoy our easy to create Private Cloud with the same flexibility and performance as our public cloud. Deploy and control easily in our self-service cloud platform. No upfront costs. Get in touch and learn more!';
const btn2Text2 = 'More secure than public cloud by design. Dedicated hosts on a Private Cloud offer isolated and managed cloud infrastructure, without public cloud’s shared security model.';
const btn2Text3 = 'Don’t worry about the extra costs of migrating from a different cloud provider. During a 2-month free migration period, we will charge you no service costs.';
const btn3Text1 = 'Run your databases hassle-free, supported by expert level installation. UpCloud Managed Databases take away the burden of maintenance. Delegate the mundane tasks to professionals and spend your valuable time more productively.';
const btn3Text2 = 'Clustered with automated failover, monitored day and night, Managed Databases are covered by our signature 100% uptime SLA. Rest assured your databases are always available.';
const btn3Text3 = 'Save your business resources by spending your valuable time on what matters lowering the total cost of ownership over the lifetime of your database services.';


bnt1.addEventListener('click', () =>{
paragraphHeader.innerText = heading1;
paragraphCenter1.innerText = btn1Text1;
paragraphCenter2.innerText = btn1Text2;
paragraphCenter3.innerText = btn1Text3;
paragraphDown.textContent= heading1;
img.src = 'images/cloud-servers.png';
img.alt = 'cloud servers';
link1.href = 'https://upcloud.com/products/cloud-servers';
});


btn2.addEventListener('click', () =>{
    paragraphHeader.innerText = heading2;
    paragraphCenter1.innerText = btn2Text1;
    paragraphCenter2.innerText = btn2Text2;
    paragraphCenter3.innerText = btn2Text3;
    paragraphDown.textContent= heading2;
    img.src= 'images/private-cloud.png';
    img.alt = 'private cloud';
    link1.href = 'https://upcloud.com/products/private-cloud';
    });


btn3.addEventListener('click', () =>{
    paragraphHeader.innerText = heading3;
    paragraphCenter1.innerText = btn3Text1;
    paragraphCenter2.innerText = btn3Text2;
    paragraphCenter3.innerText = btn3Text3;
    paragraphDown.textContent= heading3;
    img.src= 'images/managed-databases.png';
    img.alt = 'managed databases';
    link1.href = 'https://upcloud.com/products/managed-databases';
    });



