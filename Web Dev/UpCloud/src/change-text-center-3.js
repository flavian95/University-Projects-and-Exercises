

const bttn1 =document.querySelector('.blocks-div-1-p-header');
const bttn2 =document.querySelector('.blocks-div-2-p-header');
const bttn3 =document.querySelector('.blocks-div-3-p-header');
const p_Header = document.querySelector('.center-h3-3');
const p_Center1 = document.querySelector('.center-text-p-1');
const p_Center2 = document.querySelector('.center-text-p-2');
const p_Center3 = document.querySelector('.center-text-p-3');
const p_Down = document.querySelector('.center-p-text-3');
const img1 = document.querySelector('.img-center-3');
const link3 = document.querySelector('.center-a-3');
const header1 = 'Managed Load Balancer';
const header2 = 'Network Transfer Pool';
const header3 = 'Software-Defined Networking';
const header4 = 'SDN Private Networks';
const bttn1Text1 = 'Looking to diversify your services for even better redundancy? Look no further than the UpCloud Mananged Load Balancer! Add professional-grade load balancing solution to any of your cloud services quickly and easily, secured by free SSL certificates.' ;
const bttn1Text2 = 'Load Balancer is built on our true and trusted infrastructure. Service critical applications can improve resilience with the two-node Production plan.';
const bttn1Text3 = 'Load Balancer benefits from our Network Transfer Pool allowing you to forget about data transfer costs and focus on developing your applications.';
const bttn2Text1 = 'Network Transfer Pool combines all transfer quotas included in all of your UpCloud products and services into a single account-wide transfer pool, free of charge!';
const bttn2Text2 = 'Network Transfer Pool works with all of our current and future public cloud services including Cloud Servers and Object Storage. Every service with an included transfer quota contributes to the total transfer pool';
const bttn2Text3 = 'Never again pay for excess charges while part of your quota sits unused.';
const bttn3Text1 = 'Service connectivity at UpCloud is managed using software-defined networking (SDN) that enables dynamic, programmatically configured networking. It provides greater flexibility and customisability, all configurable straight from your Control Panel.';
const bttn3Text2 = 'Our SDN features such as the SDN Private Networks and Routers focus on providing improved network performance and capabilities while decoupling the network configuration from the physical infrastructure.';
const bttn3Text3 = 'Floating IPs are special IPv4 addresses that can be transferred from one Cloud Server to another at a moment’s notice without the need to restart the servers. They are extremely useful for failover services on mission-critical functions to ensure high availability.';


bttn1.addEventListener('click', () =>{
p_Header.innerText = header1;
p_Center1.innerText = bttn1Text1;
p_Center2.innerText = bttn1Text2;
p_Center3.innerText = bttn1Text3;
p_Down.textContent= header1;
img1.src = 'images/managed-load-Balancer.png';
img1.alt = 'managed load balancer';
link3.href = 'https://upcloud.com/products/managed-load-balancer';
});


bttn2.addEventListener('click', () =>{
    p_Header.innerText = header2;
    p_Center1.innerText = bttn2Text1;
    p_Center2.innerText = bttn2Text2;
    p_Center3.innerText = bttn2Text3;
    p_Down.textContent= header2;
    img1.src= 'images/network-transfer-pool.png';
    img1.alt = 'network transfer pool';
    link3.href = 'https://upcloud.com/products/network-transfer-pool';
    });


bttn3.addEventListener('click', () =>{
    p_Header.innerText = header3;
    p_Center1.innerText = bttn3Text1;
    p_Center2.innerText = bttn3Text2;
    p_Center3.innerText = bttn3Text3;
    p_Down.textContent= header4;
    img1.src= 'images/software-defined-networking.png';
    img1.alt = 'software-defined networking';
    link3.href = 'https://upcloud.com/products/software-defined-networking';
    });