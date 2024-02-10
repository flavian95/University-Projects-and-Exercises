

const button1 =document.querySelector('.blocks-div-p-1');
const button2 =document.querySelector('.blocks-div-p-2');
const button3 =document.querySelector('.blocks-div-p-3');
const pHeader = document.querySelector('.center-h3-2');
const pCenter1 = document.querySelector('.center-1-text');
const pCenter2 = document.querySelector('.center-2-text');
const pCenter3 = document.querySelector('.center-3-text');
const pDown = document.querySelector('.center-p-text-2');
const image = document.querySelector('.img-center-2');
const link2 = document.querySelector('.center-a-2');
const h1 = 'Block Storage';
const h2 = 'Object Storage';
const h3 = 'Simple Backup';
const button1Text1 = 'Block storage is our defacto cloud storage solution with the options to choose from our home-grown high-performance MaxIOPS technology and high-capacity HDD devices. Both are available on-demand basis with up to 8 storage devices per Cloud Server.' ;
const button1Text2 = 'Highly available – We developed our storage solutions to not only be highly performant but also highly reliable. Performance means nothing without reliability!';
const button1Text3 = 'Our Block storage runs on a dedicated backend separately from the computational hosts. This way your Cloud Servers can be automatically restarted on another host should the compute backend experience failure.';
const button2Text1 = 'Alternatively, if you are looking to host a large quantity of unstructured data, you will want to check out UpCloud Object Storage. As fully S3-compliant, our Object Storage is just plug-and-play with existing S3 compatible software integrations.';
const button2Text2 = 'Choose from the three capacities of 250 GB, 500 GB and 1 TB. Easily increase the storage size without needing to migrate your data';
const button2Text3 = 'Object Storage benefits fully from Network Transfer Pool by contributing to it according to the bundled transfer and utilising the pool for outgoing public network transfer.';
const button3Text1 = 'Enable and forget, you’ll then have it when you need it! No need to configure backup schedules or retention periods, just pick the longest backup duration you are likely to need and we’ll do the rest. When enabled, the backups are made as scheduled on the background without the need for user actions.';
const button3Text2 = 'Select the backup schedule according to your needs and not just the system storage, but all storages.';
const button3Text3 = 'Bring back an entire cloud server system state from one of your many backups. The full one year schedule comes with a total of 23 concurrently available backups. You will always have a backup of the data you are looking for up to a year from any changes to the data.';


button1.addEventListener('click', () =>{
pHeader.innerText = h1;
pCenter1.innerText = button1Text1;
pCenter2.innerText = button1Text2;
pCenter3.innerText = button1Text3;
pDown.textContent= h1;
image.src = 'images/block-storage.png';
image.alt = 'block storage';
link2.href = 'https://upcloud.com/products/block-storage';
});


button2.addEventListener('click', () =>{
    pHeader.innerText = h2;
    pCenter1.innerText = button2Text1;
    pCenter2.innerText = button2Text2;
    pCenter3.innerText = button2Text3;
    pDown.textContent= h2;
    image.src= 'images/object-storage.png';
    image.alt = 'object storage';
    link2.href = 'https://upcloud.com/products/object-storage';
    });


button3.addEventListener('click', () =>{
    pHeader.innerText = h3;
    pCenter1.innerText = button3Text1;
    pCenter2.innerText = button3Text2;
    pCenter3.innerText = button3Text3;
    pDown.textContent= h3;
    image.src= 'images/simple-backups.png';
    image.alt = 'simple backup';
    link2.href = 'https://upcloud.com/products/simple-backup';
    });